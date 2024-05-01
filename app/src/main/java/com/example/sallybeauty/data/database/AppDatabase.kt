package com.example.sallybeauty.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity


@Database(entities = [UserCartEntity::class, FavoriteProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
