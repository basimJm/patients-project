package come.basim.selfapplicationforpatient.data.datasource

import come.basim.selfapplicationforpatient.domin.model.patient.PatientWrapperRemoteModle
import retrofit2.http.GET

interface PatientDataSource {

    @GET("patients")
    suspend fun getPatients(): PatientWrapperRemoteModle
}