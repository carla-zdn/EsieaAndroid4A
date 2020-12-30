package com.example.esieaandroid4a.presentation.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esieaandroid4a.R
import com.example.esieaandroid4a.data.remote.ConcertApi
import com.example.esieaandroid4a.data.remote.entity.Event
import com.example.esieaandroid4a.data.remote.entity.RestConcertResponse
import com.example.esieaandroid4a.data.remote.entity.Results
import com.example.esieaandroid4a.data.remote.entity.ResultsPage
import kotlinx.android.synthetic.main.activity_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFragment : Fragment() {

    fun makeApiCall() {

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.songkick.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service  = retrofit.create(ConcertApi::class.java)

        val concertRequest = service.getConcertResponse("https://api.songkick.com/api/3.0/metro_areas/28909/calendar.json?apikey=f7BntzROcFk22SBa")

        concertRequest.enqueue(object : Callback<RestConcertResponse> {
            override fun onResponse(call: Call<RestConcertResponse>, response: Response<RestConcertResponse> ) {
                if (response.isSuccessful && response.body() != null) {

                    val concertReponse: RestConcertResponse? = response.body()

                    var eventList: List<Event> = concertReponse!!.resultsPage.results.event

                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = ListAdapter(eventList)
                    }
                } else {
                    error("KO")
                }
            }

            override fun onFailure(call: Call<RestConcertResponse>, t: Throwable) {
                error("KO")
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
            inflater.inflate(R.layout.activity_second, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeApiCall()

    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}