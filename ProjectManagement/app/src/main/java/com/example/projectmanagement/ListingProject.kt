package com.example.projectmanagement

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Button as Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmanagement.db.FirestoreCallback
import com.example.projectmanagement.model.*
import com.example.projectmanagement.model.ProjectDetails
import com.example.projectmanagement.table.project.ProjectClickListener
import com.example.projectmanagement.table.project.ProjectTableDataAdapter
import com.example.projectmanagement.utils.*
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import de.codecrafters.tableview.SortableTableView
import de.codecrafters.tableview.TableView
import java.util.*

class ListingProject : AppCompatActivity()  {
    private lateinit var projectRecyclerView: RecyclerView
    private lateinit var txtNo: TextView
    private val database = Firebase.firestore
    private lateinit var buttonAddProject : Button
    private lateinit var listOfTeamMembers : MutableList<String>
    private lateinit var teamMemberEmailViewModel: TeamMemberEmailViewModel
    private lateinit var managerProjectDetailsViewModel : ProjectDetailsViewModel
    private lateinit var tableView: SortableTableView<ProjectDetails>
    private lateinit var context : Context
    private lateinit var profilePic: ImageView
    private lateinit var name : TextView
    private lateinit var role :TextView
    companion object{
        private const val TAG = "ListingProject"
        private const val CREATE_REQUEST_CODE = 248

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_ProjectManagement)
        setContentView(R.layout.activity_listing_project)

        //projectRecyclerView = findViewById(R.id.rvProjectShown)
        txtNo = findViewById(R.id.txtNoProjects)
        listOfTeamMembers = mutableListOf()

        tableView = findViewById(R.id.tableView)
        tableView.columnCount=3
        context = this

//        projectRecyclerView.addOnItemTouchListener(
//            RecyclerView.OnItemTouchListener(RecyclerItemClickListenr(this, projectRecyclerView, object : RecyclerItemClickListenr.OnItemClickListener {
//
//                override fun onItemClick(view: View, position: Int) {
//                    //do your work here..
//                }
//                override fun onItemLongClick(view: View?, position: Int) {
//                    TODO("do nothing")
//                }
//            }))
//        )
        teamMemberEmailViewModel = ViewModelProvider(this).get(TeamMemberEmailViewModel::class.java)
        getTeamMemberEmails(USER_ROLE_TEAM_MEMBER)
        managerProjectDetailsViewModel = ViewModelProvider(this).get(ProjectDetailsViewModel::class.java)
        val intent = intent
        profilePic = findViewById(R.id.imageTeamManager)
        if(null != intent.getStringExtra("profileImage")) {
            Picasso.get().load(intent.getStringExtra("profileImage")).into(profilePic);
            profilePic.scaleType = ImageView.ScaleType.CENTER_CROP
        }
        name = findViewById(R.id.txtUserName)
        role = findViewById(R.id.txtUserRole)
        name.text = "Name : "+intent.getStringExtra("name")
        name.isEnabled = false
        role.text = "Role : "+intent.getStringExtra("role")
        getProjectDetailsOfManager(intent.getStringExtra("email")!!)
        buttonAddProject = findViewById<Button>(R.id.btnAddProject)

        tableView.addDataClickListener(ProjectClickListener(this,intent.getStringExtra("name")!!,intent.getStringExtra("role")!!,intent.getStringExtra("email")!!, intent.getStringExtra("profileImage")!! ))
        buttonAddProject.setOnClickListener{

            val prevIntent = intent;
            val intent = Intent(this@ListingProject, com.example.projectmanagement.ProjectDetails::class.java)
            intent.putExtra("name",prevIntent.getStringExtra("name") )
            intent.putExtra("email", prevIntent.getStringExtra("email"))
            intent.putExtra("role", prevIntent.getStringExtra("role"))
            intent.putExtra("profileImage", prevIntent.getStringExtra("profileImage"))
            intent.putExtra("code", INTENT_FROM_PROJECT_LIST)
            startActivity(intent)
            finish()

        }




    }

//    private fun getProjectDetailsOfManager(email : String) {
//        managerProjectDetailsViewModel.getProjectDetails(object : FirestoreCallback{
//            override fun onTeamMemberListCallBack(teamMemberLst: MutableList<String>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onProjectDetailsCallback(projectDetails: MutableList<ProjectDetails>) {
//                val adapter = ProjectListAdapter(projectDetails)
//                projectRecyclerView.adapter = adapter
//                projectRecyclerView.layoutManager = LinearLayoutManager(this@ListingProject)
//                if (projectDetails.isNotEmpty()) {
//                    txtNo.isVisible = false
//                    projectRecyclerView.isVisible = true;
//                } else {
//                    txtNo.isVisible = true;
//                    projectRecyclerView.isVisible = false;
//                }
//            }
//
//
//        }, email = email)
//
//    }

    private fun getProjectDetailsOfManager(email : String) {
        managerProjectDetailsViewModel.getProjectDetails(object : FirestoreCallback {
            override fun onTeamMemberListCallBack(teamMemberLst: MutableList<String>) {
                TODO("Not yet implemented")
            }

            override fun onProjectDetailsCallback(projectDetails: MutableList<ProjectDetails>) {
                val adapter = ProjectTableDataAdapter(context,projectDetails,tableView)
                tableView.dataAdapter = adapter
                tableView.headerAdapter = TableHeader.getProjectTableHeader(context, "")
                tableView.setColumnComparator(0,ProjectNameComparator())
                tableView.setColumnComparator(1,ProjectStatusComparator())
                tableView.setColumnComparator(2,ProjectDeadlineComparator())

                if (projectDetails.isNotEmpty()) {
                    txtNo.isVisible = false
                    tableView.isVisible = true;
                } else {
                    txtNo.isVisible = true;
                    tableView.isVisible = false;
                }

            }

            override fun onOneProjectDetailsCallback(projectDetails: ProjectDetails) {
                TODO("Not yet implemented")
            }

            override fun onTeamMemberProjectCallback(projectDetails: MutableList<ProjectDetails>) {
                TODO("Not yet implemented")
            }
        }, email = email)

    }

    private fun getTeamMemberEmails(role: String) {
       teamMemberEmailViewModel.getTeamMemberDetails(object : FirestoreCallback{
           override fun onTeamMemberListCallBack(teamMemberLst: MutableList<String>) {
               listOfTeamMembers = teamMemberLst
               println(listOfTeamMembers)


           }

           override fun onProjectDetailsCallback(projectDetails: MutableList<ProjectDetails>) {
               TODO("Not yet implemented")
           }

           override fun onOneProjectDetailsCallback(projectDetails: ProjectDetails) {
               TODO("Not yet implemented")
           }

           override fun onTeamMemberProjectCallback(projectDetails: MutableList<ProjectDetails>) {
               TODO("Not yet implemented")
           }
       }, role = "Team Member")
       }




    private fun createDummyProjectDetails(): ProjectDetails {
        var taskLst = mutableListOf<TaskDetails>()
        var taskDetails = TaskDetails(
            Integer.toUnsignedLong(Timestamp.now().nanoseconds),
            "TasKName1",
            TASK_STATUS_ONGOING,
            Timestamp.now(),
            "C@live1.com"
        )
        taskLst.add(taskDetails)
        taskDetails = TaskDetails(
            Date().getTime(),
            "TasKName2",
            TASK_STATUS_ONGOING,
            Timestamp.now(),
            "C@live2.com"
        )
        taskLst.add(taskDetails)
        taskDetails = TaskDetails(
            Date().getTime(),
            "TasKName3",
            TASK_STATUS_ONGOING,
            Timestamp.now(),
            "C@live3.com"
        )
        taskLst.add(taskDetails)

        return ProjectDetails(
            Date().getTime(),
            "Project1",
            "C@live.com",
            PROJECT_STATUS_PENDING,
            Timestamp.now(),
            taskLst,
            Timestamp.now(),
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.heading_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuLogout-> Intent(this@ListingProject, MainActivity::class.java).also {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK )
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(it)

            }
        }
        return super.onOptionsItemSelected(item)
    }


    }




