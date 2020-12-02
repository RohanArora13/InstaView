package com.example.instaview

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.example.instaview.model.ImageModel
import kotlinx.android.synthetic.main.image_item.view.*
import java.io.File
import java.io.FileOutputStream
import kotlin.math.log

class ImageRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG: String = "AppDebug"

    private var items: List<ImageModel> = ArrayList()

    private lateinit var  context_main : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.image_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: ArrayList<ImageModel>){
        items = blogList
    }

    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

       // val blog_image = itemView.main_image
        val slide_image = itemView.slider
        val bookmark_image=itemView.bookmark_image
        val share_image = itemView.share_image
        val heart_image = itemView.heart_image

        var checked =  false
        var heart_checked =  false

        var position_image = 0

        fun bind(ImageModel: ImageModel){

            bookmark_image.setOnClickListener{
                Log.d("debug","clicked")
                if(checked==false){
                    bookmark_image.setImageResource(R.drawable.bookmark_blue)
                    checked=true
                }else{
                    bookmark_image.setImageResource(R.drawable.bookmark_grey)
                    checked=false
                }
            }

            heart_image.setOnClickListener{
                Log.d("debug","clicked")
                if(heart_checked==false){
                    heart_image.setImageResource(R.drawable.heart_red)
                    heart_checked=true
                }else{
                    heart_image.setImageResource(R.drawable.heart_grey)
                    heart_checked=false
                }
            }


            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

           // Log.d("debug","Arraylist Slidermodel "+ImageModel.images[0].imageUrl )

            slide_image.setImageList(ImageModel.images)

//            Glide.with(itemView.context)
//                .applyDefaultRequestOptions(requestOptions)
//                .load(ImageModel.images)
//                .into(blog_image)


            val myDrawable = share_image.drawable
            var bitmap = (myDrawable as BitmapDrawable).bitmap

            slide_image.setItemChangeListener(object : ItemChangeListener {
                override fun onItemChanged(position: Int) {
                    Log.d("debug"," change position = " +position)
                    position_image = position

                    Glide.with(itemView.context)
                        .asBitmap()
                        .load(ImageModel.images[position_image].imageUrl)
                        .into(object : CustomTarget<Bitmap>(){
                            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {

                                Log.d("debug"," bitmap " )
                                bitmap = resource
                            }
                            override fun onLoadCleared(placeholder: Drawable?) {
                            }
                        })
                }

            })

            Glide.with(itemView.context)
                .asBitmap()
                .load(ImageModel.images[position_image].imageUrl)
                .into(object : CustomTarget<Bitmap>(){
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {

                        Log.d("debug"," bitmap " )
                        bitmap = resource
                    }
                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })

            share_image.setOnClickListener{

                try {

                    val file = File(itemView.context.getExternalFilesDir(null), "share_image_" + System.currentTimeMillis() + ".png")
                    val fOut = FileOutputStream(file)
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
                    fOut.flush()
                    fOut.close()
                    file.setReadable(true, false)
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    val photoURI =  FileProvider.getUriForFile(itemView.context, itemView.context.getApplicationContext().getPackageName() + ".provider", file);
                    intent.putExtra(Intent.EXTRA_STREAM, photoURI)
                    intent.type = "image/png"
                    itemView.context.startActivity(Intent.createChooser(intent, "Share image via"))
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }




        }

    }

}