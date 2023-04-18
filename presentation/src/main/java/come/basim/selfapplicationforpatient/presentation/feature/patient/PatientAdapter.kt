package come.basim.selfapplicationforpatient.presentation.feature.patient

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import come.basim.selfapplicationforpatient.domin.model.patient.PatientRemotModel
import come.basim.selfapplicationforpatient.presentation.databinding.FragmentRowBinding

class PatientAdapter(private val patient : List<PatientRemotModel>) :
    RecyclerView.Adapter< PatientAdapter.PatientViewHolder>() {

    var lastSelected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {

        val binding = FragmentRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PatientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val model = patient[position]
        holder.bind(model, position)

    }

    inner class PatientViewHolder(private val binding: FragmentRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: PatientRemotModel, position: Int) {
            binding.model = model

            binding.cardView.setOnClickListener {
                if (position != lastSelected) {

                    if (lastSelected != -1) {
                        patient[lastSelected].selected = false
                        notifyItemChanged(lastSelected)
                    }

                    lastSelected = position
                    patient[position].selected = true
                    notifyItemChanged(position)

                }

            }

        }


    }

   //private object DiffCallBack : DiffUtil.ItemCallback<PatientRemotModel>() {
   //    override fun areItemsTheSame(
   //        oldItem: PatientRemotModel,
   //        newItem: PatientRemotModel
   //    ): Boolean {
   //        return oldItem.id == newItem.id
   //    }

   //    override fun areContentsTheSame(
   //        oldItem: PatientRemotModel,
   //        newItem: PatientRemotModel
   //    ): Boolean {
   //        return oldItem == newItem
   //    }

   //}

    override fun getItemCount(): Int {
       return patient.size
    }
}


