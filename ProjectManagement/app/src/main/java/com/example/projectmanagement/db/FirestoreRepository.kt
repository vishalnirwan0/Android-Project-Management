package com.example.projectmanagement.db

import android.util.Log
import com.example.projectmanagement.ListingProject
import com.example.projectmanagement.model.ProjectDetails
import com.example.projectmanagement.model.UserDetails
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirestoreRepository {
    private var database = Firebase.firestore

    companion object{
        const val TAG = "TeamMemberDetails"
    }

   fun getTeamMemberDetailsUsingCallBack(callback: FirestoreCallback){
       var teamMemberEmailLst: MutableList<String> = mutableListOf()
       var userDetailsLst = mutableListOf<UserDetails>()
       database.collection("userDetails").
       whereEqualTo("role","Team Member").get().addOnCompleteListener{ task ->
           if(task.isSuccessful){
               userDetailsLst = task.result.toObjects(UserDetails::class.java)
               for(userDetails in userDetailsLst){
                   teamMemberEmailLst.add(userDetails?.email!!)
               }
               callback.onTeamMemberListCallBack(teamMemberEmailLst)
               return@addOnCompleteListener

           }else{
               Log.d(TAG, "Error in getTeamMember Details :",task.exception)
           }
       }
   }

    fun getManagerProjectDetails(projectDetailsCallback : FirestoreCallback){
        var projectDetailsLst = mutableListOf<ProjectDetails>()
        database.collection("projectDetails").
        whereEqualTo("projectCreatedBy","C@live.com").get().addOnCompleteListener{ task ->
            if(task.isSuccessful){
                projectDetailsLst = task.result.toObjects(ProjectDetails::class.java)
            }else{
                Log.e(TAG, "Error in getManagerProjectDetails Details :",task.exception)
            }
            projectDetailsCallback.onProjectDetailsCallback(projectDetailsLst)
            return@addOnCompleteListener

        }
}}