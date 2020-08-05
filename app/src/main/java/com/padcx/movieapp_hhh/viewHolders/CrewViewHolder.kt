package mk.padc.themovie.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padcx.movieapp_hhh.data.vos.*
import com.padcx.movieapp_hhh.delegate.DetailDelegate
import com.padcx.movieapp_hhh.util.img_url_actor
import com.padcx.movieapp_hhh.viewHolders.AbstractCastviewHolder
import com.padcx.movieapp_hhh.viewHolders.AbstractCrewviewHolder
import com.padcx.movieapp_hhh.viewHolders.BaseViewHolder
import kotlinx.android.synthetic.main.best_actor_item.view.*


class CrewViewHolder(itemView: View)
    : AbstractCrewviewHolder(itemView) {

    init { }

    override fun bindData(data: ResultVO) {

    }

    override fun bindActorData(data: ActorVO) {

    }

    override fun bindShowCaseData(data: ShowCaseVO) {

    }

    override fun bindDiscoverData(data: DiscoverVO) {

    }

    override fun bindCastData(data: CastVO) {

    }

    override fun bindCreatorData(data: CrewVO) {
        mCrewData=data
        itemView.tvActorName.text = data.name
        var imgurl = img_url_actor +data.profile_path
        Glide
            .with(itemView.context)
            .load(imgurl)
            .into(itemView.igActor)
    }
}