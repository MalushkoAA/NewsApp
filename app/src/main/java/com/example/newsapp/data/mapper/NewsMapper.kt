package com.example.newsapp.data.mapper

import com.example.newsapp.data.db.NewsItemDbModel
import com.example.newsapp.data.network.models.NewsItemDto
import com.example.newsapp.domain.entity.NewsItem

class NewsMapper {

    fun mapDtoToDbModel(dto:NewsItemDto)=NewsItemDbModel(
        content=dto.content,
        description=dto.description,
        publishedAt=dto.publishedAt,
        title=dto.title,
        url = dto.url,
        urlToImage=dto.urlToImage
    )

    fun mapDbModelToEntity(dbModel: NewsItemDbModel)=NewsItem(
        content=dbModel.content,
        description=dbModel.description,
        publishedAt=dbModel.publishedAt,
        title=dbModel.title,
        url = dbModel.url,
        urlToImage=dbModel.urlToImage
    )

}