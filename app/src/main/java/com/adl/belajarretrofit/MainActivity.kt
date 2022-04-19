package com.adl.belajarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adl.belajarretrofit.model.OMDBResponse
import com.adl.belajarretrofit.services.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitConfig().getAPIService().getDetailMovie().enqueue(object: Callback<OMDBResponse>{
            override fun onResponse(call: Call<OMDBResponse>, response: Response<OMDBResponse>) {
              Log.d("Response",response.toString())
            }

            override fun onFailure(call: Call<OMDBResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.localizedMessage,Toast.LENGTH_LONG).show()
            }


        })
    }


}