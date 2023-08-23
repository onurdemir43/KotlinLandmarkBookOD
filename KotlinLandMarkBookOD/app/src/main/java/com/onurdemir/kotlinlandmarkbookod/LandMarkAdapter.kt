package com.onurdemir.kotlinlandmarkbookod

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onurdemir.kotlinlandmarkbookod.databinding.RecyclerRowBinding

class LandMarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandMarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return LandmarkHolder(binding)
    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            //intent.putExtra("landmark",landmarkList.get(position))
            Singleton.chosenLandmark = landmarkList.get(position)
            holder.itemView.context.startActivity(intent)
        }




    }
}