package com.example.recipesapp.repository.recipe.model

data class RecipeModel(
    val id: Long?,
    val name: String,
    val description: String?,
    val user_ratings: UserRatings?,
    val price: Price?,
    val tags: MutableList<Tag>?,
    val thumbnail_url: String?
) {
    constructor(
        id: Long?,
        name: String,
        description: String?,
        user_ratingsDTO: UserRatingsDTO?,
        price: Price?,
        tags: MutableList<Tag>?,
        thumbnail_url: String?
    ) : this(
        id,
        name,
        description,
        user_ratingsDTO?.toModel(),
        price,
        tags,
        thumbnail_url
    )
}

data class UserRatings(
    val count_positive: Long?,
    val score: Double?,
    val count_negative: Long?
)

data class Price(
    val consumption_portion: Int?,
    val total: Int?,
    val updated_at: String?,
    val portion: Int?,
    val consumption_total: Int?
)

data class Tag(
    val display_name: String?,
    val type: String?,
    val root_tag_type: String?,
    val name: String?,
    val id: Long?
)