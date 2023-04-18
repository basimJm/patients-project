package come.basim.selfapplicationforpatient.domin.model.patient

import com.google.gson.annotations.SerializedName

data class PatientRemotModel (

    val condition: String,

    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val namePatients: String,

    val address: String,

    val mobile: String,

    val email: String,

    val birthdate: String,

    val gender: String,

    val photo: String,



    //loacalVar
    var selected :Boolean= false,




)




