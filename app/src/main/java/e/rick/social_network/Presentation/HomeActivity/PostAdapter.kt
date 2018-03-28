package e.rick.social_network.Presentation.HomeActivity

import android.content.Context
import android.content.res.Resources
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import e.rick.social_network.Model.PostObj
import e.rick.social_network.R
import kotlinx.android.synthetic.main.list_item.view.*
import org.jetbrains.anko.find

class PostAdapter (private val listItem : ArrayList<PostObj>, private val context : Context): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var post = listItem[position]

        holder.username?.text = post.username

        post.imageBody?.let {

            val imageBody = ImageView(context)
//            imageBody.setImageResource(post.imageBody)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var username : TextView? = null
        var postBody : ConstraintLayout? = null

        init {

            this.username = itemView?.findViewById<TextView>(R.id.username)
            this.postBody = itemView?.findViewById<ConstraintLayout>(R.id.container)
        }
    }
}