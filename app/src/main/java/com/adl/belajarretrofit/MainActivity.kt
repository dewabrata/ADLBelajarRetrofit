package com.adl.belajarretrofit

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.adl.belajarretrofit.adapter.FeatureListEducationCategoryList1Adapter
import com.adl.belajarretrofit.model.OMDBResponse
import com.adl.belajarretrofit.model.SearchItem
import com.adl.belajarretrofit.model.SearchResponse
import com.adl.belajarretrofit.services.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var listDataHeader: MutableList<String>
    private lateinit var listDataChild: HashMap<String, List<SearchItem>>
    private lateinit var featureListEducationCategoryList1Adapter: FeatureListEducationCategoryList1Adapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initToolbar()


        RetrofitConfig().getAPIService().searchMovie("titanic").enqueue(object: Callback<SearchResponse>{
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
              Log.d("Response",response.toString())
                val data: SearchResponse? = response.body()


                dataGenerate(data?.search as List<SearchItem>)


            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.localizedMessage,Toast.LENGTH_LONG).show()
            }


        })
    }


    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Category List 1"

        try {
            toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))

        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }


    fun dataGenerate ( list :List<SearchItem>){
        listDataHeader = ArrayList()
        listDataChild = HashMap()

        listDataHeader.add("Result Movie")

        listDataChild["Result Movie"] = list

        featureListEducationCategoryList1Adapter = FeatureListEducationCategoryList1Adapter(this, listDataHeader, listDataChild)

        lvExp.setAdapter(featureListEducationCategoryList1Adapter)

    }
}