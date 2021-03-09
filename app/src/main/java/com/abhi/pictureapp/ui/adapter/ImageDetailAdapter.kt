package com.abhi.pictureapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.abhi.pictureapp.R
import com.abhi.pictureapp.data.model.ImageDataModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

// image and detail loading adapter for detail page

class ImageDetailAdapter(
    val imageList: ArrayList<ImageDataModel>,
    val context: FragmentActivity
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.layout_image_detail, null)
        val imgPreviewDetail = view.findViewById(R.id.imgPreviewDetail) as ImageView
        val tvTitle = view.findViewById(R.id.tvTitle) as TextView
        val tvCopyright = view.findViewById(R.id.tvCopyright) as TextView
        val tvDate = view.findViewById(R.id.tvDate) as TextView
        val tvExplanation = view.findViewById(R.id.tvExplanation) as TextView
        val tvHdUrl = view.findViewById(R.id.tvHdUrl) as TextView
        val tvMediaType = view.findViewById(R.id.tvMediaType) as TextView
        val tvServiceVersion = view.findViewById(R.id.tvServiceVersion) as TextView

        tvTitle.text = imageList[position].title
        tvCopyright.text = imageList[position].copyright
        tvDate.text = imageList[position].date
        tvExplanation.text = imageList[position].explanation
        tvHdUrl.text = imageList[position].hdurl
        tvMediaType.text = imageList[position].media_type
        tvServiceVersion.text = imageList[position].service_version

        val optionsImage: RequestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

        Glide.with(imgPreviewDetail.context)
            .load(imageList[position].url)
            .apply(optionsImage)
            .into(imgPreviewDetail)

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view: View? = `object` as View?
        viewPager.removeView(view)
    }
}