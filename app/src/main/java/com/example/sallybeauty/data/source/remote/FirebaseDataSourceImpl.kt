package com.example.sallybeauty.data.source.remote

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.example.sallybeauty.domain.entity.user.FirebaseSignInUserEntity
import io.github.nefilim.kjwt.JWT
import io.github.nefilim.kjwt.toJWTKeyID
import java.time.Instant
import javax.inject.Inject


class FirebaseDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    firestore: FirebaseFirestore,
) : FirebaseDataSource {

    private val collection = firestore.collection("users")
    override fun signUpWithFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseAuth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener {
                onFailure(it.message ?: "An error occurred")
            }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun signInWithFirebase(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseAuth.signInWithEmailAndPassword(user.email, user.password)
            .addOnSuccessListener {
                val firebaseUser = it.user
                onSuccess(
                    UserInformationEntity(
                        id = firebaseUser?.uid ?: "",
                        name = firebaseUser?.displayName ?: "",
                        surname = "",
                        email = firebaseUser?.email ?: "",
                        phone = firebaseUser?.phoneNumber ?: "",
                        image = firebaseUser?.photoUrl.toString(),
                        password = "",
                        token = createJwtTokenForFirebaseUser(),
                    ),
                )
            }.addOnFailureListener {
                onFailure(it.message ?: "An error occurred")
            }
    }

    override fun forgotPassword(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener {
                onFailure(it.message ?: "An error occurred")
            }
    }

    override fun writeUserDataToFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        val userMap = hashMapOf(
            "id" to firebaseAuth.uid,
            "name" to user.name,
            "surname" to user.surname,
            "email" to user.email,
            "phone" to user.phone,
            "image" to user.image,
        )
        val firebaseUser = firebaseAuth.currentUser
        val profileUpdate = userProfileChangeRequest {
            displayName = userMap["name"]
            photoUri = Uri.parse(userMap["image"])
        }
        firebaseUser?.updateProfile(profileUpdate)
        collection.document(firebaseAuth.uid!!).set(userMap)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener {
                onFailure(it.message ?: "An error occurred")
            }
    }

    override fun readUserDataFromFirebase(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        collection.document(userId).get()
            .addOnSuccessListener { snapshot ->
                onSuccess(
                    UserInformationEntity(
                        id = snapshot.getString("id") ?: "",
                        name = snapshot.getString("name") ?: "",
                        surname = snapshot.getString("surname") ?: "",
                        email = snapshot.getString("email") ?: "",
                        phone = snapshot.getString("phone") ?: "",
                        image = snapshot.getString("image") ?: "",
                        password = "",
                        token = "",
                    ),
                )
            }.addOnFailureListener {
                onFailure(it.message ?: "An error occurred")
            }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createJwtTokenForFirebaseUser(): String {
        val now = Instant.now()
        val expirationTime = now.plusSeconds(180)
        val jwt = JWT.es256("fb-user123".toJWTKeyID()) {
            issuedAt(now)
            claim("exp", expirationTime.epochSecond)
        }.encode()
        return jwt
    }
}
