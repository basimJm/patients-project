package come.basim.selfapplicationforpatient.domin.model.patient

data class PatientWrapperRemoteModle (
    val status: Int,
    val message: String,
    val data: List<PatientRemotModel>
        )


