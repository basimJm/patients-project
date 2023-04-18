package come.basim.selfapplicationforpatient.domin.usecase

import come.basim.selfapplicationforpatient.domin.PatientRepostitory
import come.basim.selfapplicationforpatient.domin.model.patient.PatientRemotModel
import javax.inject.Inject

class GetPatientUseCase @Inject constructor(private val repostitory: PatientRepostitory) {

    suspend operator fun invoke() : List<PatientRemotModel>{
        return repostitory.getPatients()
    }


}