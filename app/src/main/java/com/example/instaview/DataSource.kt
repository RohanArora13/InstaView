package com.example.instaview

import com.denzcoskun.imageslider.models.SlideModel
import com.example.instaview.model.ImageModel

class DataSource {

    companion object{

        fun createDataSet(): ArrayList<ImageModel>{
            val list = ArrayList<ImageModel>()

            val l1: ArrayList<SlideModel> = ArrayList()
            l1.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_1.1.jpg"))
            l1.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_1.2.jpg"))
            l1.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_1.3.jpg"))
            l1.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_1.4.jpg"))

            list.add(
                ImageModel(
                    l1
                )
            )

            val l2: ArrayList<SlideModel> = ArrayList()
            l2.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_2.1.jpg"))
            l2.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_2.2.jpg"))
            l2.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_2.3.jpg"))
            l2.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_2.4.jpg"))
            l2.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_2.5.jpg"))

            list.add(
                ImageModel(
                    l2
                )
            )
            val l3: ArrayList<SlideModel> = ArrayList()
            l3.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_3.jpg"))

            list.add(
                ImageModel(
                    l3
                )
            )

            val l4: ArrayList<SlideModel> = ArrayList()
            l4.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_4.1.jpg"))
            l4.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_4.2.jpg"))
            l4.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_4.3.jpg"))
            l4.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_4.4.jpg"))


            list.add(
                ImageModel(
                    l4
                )
            )

            val l5: ArrayList<SlideModel> = ArrayList()
            l5.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_5.1.jpg"))
            l5.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_5.2.jpg"))
            l5.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_5.3.jpg"))
            l5.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_5.4.jpg"))


            list.add(
                ImageModel(
                    l5
                )
            )

            val l6: ArrayList<SlideModel> = ArrayList()
            l6.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_6.1.jpg"))
            l6.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_6.2.jpg"))
            l6.add(SlideModel("https://raw.githubusercontent.com/RohanArora13/Images/master/insta_6.3.jpg"))

            list.add(
                ImageModel(
                    l6
                )
            )


//            list.add(
//                ImageModel(
//                    ""
//                )
//            )
//            list.add(
//                ImageModel(
//                    ""
//                )
//            )

            return list
        }
    }
}