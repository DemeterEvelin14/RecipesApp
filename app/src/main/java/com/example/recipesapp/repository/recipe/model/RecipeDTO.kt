package com.example.recipesapp.repository.recipe.model

data class RecipeDTO(
    val id: Long?,
    val name: String,
    val description: String? = "Default",
    val user_ratings: UserRatings?,
    val price: Price?,
    val tags: MutableList<Tag>,
    val thumbnail_url: String?
)

data class UserRatingsDTO(
    val count_positive: Long?,
    val score: Double? = 1.0,
    val count_negative: Long?
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.id,
        name = this.name,
        description = this.description,
        user_ratings = this.user_ratings,
        price = this.price,
        tags = this.tags,
        thumbnail_url = this.thumbnail_url
    )
}

fun UserRatingsDTO.toModel(): UserRatings {
    return UserRatings(
        count_positive = this.count_positive,
        score = this.score!! *10,
        count_negative = this.count_negative
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }