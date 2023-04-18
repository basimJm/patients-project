package come.basim.selfapplicationforpatient.domin.model.patient

import com.google.gson.annotations.SerializedName

data class TestPatient (
    @SerializedName("_id")
    val id:String,

    val type:String,

    val reading:String,

    val date:String
        )


