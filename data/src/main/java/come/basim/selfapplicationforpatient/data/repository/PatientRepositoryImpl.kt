package come.basim.selfapplicationforpatient.data.repository

import come.basim.selfapplicationforpatient.data.datasource.PatientDataSource
import come.basim.selfapplicationforpatient.domin.PatientRepostitory
import come.basim.selfapplicationforpatient.domin.model.patient.PatientRemotModel
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(private val patientDataSource: PatientDataSource) :
    PatientRepostitory {


    override suspend fun getPatients(): List<PatientRemotModel> {
        return patientDataSource.getPatients().data
    }
}