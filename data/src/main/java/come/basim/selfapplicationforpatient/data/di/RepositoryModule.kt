package come.basim.selfapplicationforpatient.data.di

import come.basim.selfapplicationforpatient.data.datasource.PatientDataSource
import come.basim.selfapplicationforpatient.data.repository.PatientRepositoryImpl
import come.basim.selfapplicationforpatient.domin.PatientRepostitory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(patientDataSource: PatientDataSource):PatientRepostitory{
        return PatientRepositoryImpl(patientDataSource)
    }
}