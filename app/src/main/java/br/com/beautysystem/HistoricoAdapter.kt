package br.com.beautysystem


import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class HistoricoAdapter(
        val historicos: List<Historico>, val onClick : (Historico) -> Unit)
    : RecyclerView.Adapter<HistoricoAdapter.HistoricoViewHolder>() {


    class HistoricoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg: ImageView
        val cardData: TextView
        val cardHora: TextView
        val cardView: CardView


        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardData = view.findViewById(R.id.card_data)
            cardHora = view.findViewById(R.id.card_hora)
            cardImg = view.findViewById(R.id.card_imagem)
            cardView = view.findViewById(R.id.card_disciplinas)


        }

    }

    override fun getItemCount() = this.historicos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricoViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_historico,parent,false)

        val holder = HistoricoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: HistoricoViewHolder, position: Int) {

        val contexto = holder.itemView.context
        val historico = this.historicos[position]

        holder.cardNome.text = historico.tratamento
        holder.cardData.text = historico.data
        holder.cardHora.text = historico.hora


        Picasso.with(contexto).load(historico.foto).fit().into(holder.cardImg,object: com.squareup.picasso.Callback {
            override fun onSuccess() {

            }

            override fun onError() {

            }
        })
        holder.itemView.setOnClickListener{onClick(historico)}
    }


}


