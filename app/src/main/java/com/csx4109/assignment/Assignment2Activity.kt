package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.databinding.ActivityAssignment2Binding
import com.example.recyclerviewwithlistandgridview.Itemadapter
import com.example.recyclerviewwithlistandgridview.model.infromation

class Assignment2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAssignment2Binding

    private val List_View ="List_View"
    private val Grid_View = "Grid_View"
    var currentView = List_View



    private val userScores = listOf(
        infromation("Roblox", "Roblox is a global platform where millions of people gather together every day to imagine, create, and share experiences with each other in immersive, user-generated 3D worlds.", 100, R.drawable.roblox),
        infromation("Overwatch", "Overwatch was an online team-based game generally played as a first-person shooter. ", 90, R.drawable.overwatch),
        infromation("Valorant ", " Valorant is an online multiplayer computer game, produced by Riot Games.", 25, R.drawable.valorant),
        infromation("Palworld", "Palworld is an upcoming action-adventure survival game by Japanese developer Pocket Pair.", 70, R.drawable.palworld),
        infromation("league of legends", " League of Legends is a team-based strategy game where two teams of five powerful champions face off to destroy the other's base.", 80, R.drawable.league_of_legends),
        infromation("TEAMFIGHT TACTICS", "Teamfight Tactics (TFT) is an auto battler game developed and published by Riot Games.", 85, R.drawable.tft),
        infromation("Minecraft ", "Minecraft is a game where players place blocks and go on adventures.", 90, R.drawable.minecraft),
        infromation("Devil may cry  ", "Devil May Cry is an action-adventure game franchise created by Hideki Kamiya.", 50, R.drawable.devil_may_cry),
        infromation("Splatoon", "Splatoon is a third-person shooter developed and published by Nintendo.", 50, R.drawable.splatoon),


        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAssignment2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.floatingActionButton.setOnClickListener{
            if (currentView== List_View){
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@Assignment2Activity,R.drawable.list)
                )
                gridview()

            }else{
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(this@Assignment2Activity,R.drawable.grid)
                )
                listview()

            }
        }
    }

    private fun listview(){
        currentView = List_View
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = Itemadapter(this,userScores)



    }

    private fun gridview() {
        currentView = Grid_View
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2) // You can adjust the spanCount
        binding.recyclerView.adapter = Itemadapter(this,userScores)
    }


}