package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import com.fasterxml.jackson.annotation.JsonInclude
import no.nav.bidrag.behandling.felles.grunnlag.Periode
import java.time.LocalDate

abstract class Delberegning<T>(@field:JsonInclude var grunnlagReferanseListe: List<String>, datoFom: LocalDate, datoTil: LocalDate?) :
    Periode<T>(datoFom, datoTil) {

    abstract override fun isEqualTo(other: T): Boolean
}
