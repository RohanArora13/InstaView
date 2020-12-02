package com.example.instaview.model

import com.denzcoskun.imageslider.models.SlideModel

data class ImageModel(

    var images: ArrayList<SlideModel>


) {

    override fun toString(): String {
        return "BlogPost(image_list='$images')"
    }


}