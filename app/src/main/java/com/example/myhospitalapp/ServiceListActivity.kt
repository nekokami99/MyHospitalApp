package com.example.myhospitalapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
const val TAG = "ServiceListActivity"

class ServiceListActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var serviceRecyclerview : RecyclerView
    private lateinit var serviceArrayList: ArrayList<Services>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_list)

        serviceRecyclerview = findViewById(R.id.serviceList)
        serviceRecyclerview.layoutManager = LinearLayoutManager(this)
        serviceRecyclerview.setHasFixedSize(true)

        serviceArrayList = arrayListOf()


        getServiceData()
    }

    private fun getServiceData() {
        dbref = FirebaseDatabase.getInstance().getReference("Service")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    Log.d(TAG, "snapshot: $snapshot")
                    for(serviceSnapshot in snapshot.children){
                        val ser = serviceSnapshot.getValue(Services::class.java)
                        serviceArrayList.add(ser!!)
                    }
                    serviceRecyclerview.adapter = ServiceAdapter(serviceArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}