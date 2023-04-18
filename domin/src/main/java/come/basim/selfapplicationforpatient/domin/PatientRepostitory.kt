package come.basim.selfapplicationforpatient.domin

import come.basim.selfapplicationforpatient.domin.model.patient.PatientRemotModel

interface PatientRepostitory {

    suspend fun getPatients():List<PatientRemotModel>
}