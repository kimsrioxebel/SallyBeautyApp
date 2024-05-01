package com.example.sallybeauty.domain.mapper

interface ProductBaseMapper<I, O> {
    fun map(input: Any): O
}
