package com.example.flavorsdemo.feature.multipleview.data.repository

import com.example.flavorsdemo.comman.Resource
import com.example.flavorsdemo.feature.multipleview.data.model.toEntity
import com.example.flavorsdemo.feature.multipleview.data.source.MultipleViewSource
import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity
import com.example.flavorsdemo.feature.multipleview.domain.repository.MultipleViewRepository
import javax.inject.Inject

class MultipleViewRepositoryImpl @Inject constructor(private val source: MultipleViewSource) :
    MultipleViewRepository {
    override suspend fun getData(): Resource<List<MultipleViewEntity>> {
        val multipleViewEntity = source.getData()
        val items = multipleViewEntity.data!!.map {
            /*        when (it?.type) {
                        "text" -> MultipleViewEntity.TextData(it.type.toString(), it.text.toString())
                        "image" -> MultipleViewEntity.ImageData(
                            it.type.toString(),
                            it.text.toString(),
                            it.image.toString()
                        )
                        "carousel" -> MultipleViewEntity.CarouselData(
                            it.type.toString(),
                            it.text.toString(),
                            it.items as List<ItemData>
                        )
                        else -> {
                            throw IllegalStateException("Unknown view")
                        }
                    }*/
            it!!.toEntity()
        }
        return Resource.Success(items)
    }
}