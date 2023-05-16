package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import com.fasterxml.jackson.annotation.JsonInclude
import no.nav.bidrag.behandling.felles.enums.InntektType
import no.nav.bidrag.behandling.felles.enums.Rolle
import java.math.BigDecimal
import java.time.LocalDate

class Kapitalinntekt(
    rolle: Rolle,
    inntektType: InntektType,
    belop: BigDecimal,
    gjelderAar: String,
    valgt: Boolean,
    datoFom: LocalDate,
    datoTil: LocalDate?,
    inntekter: List<IInntektGrunnlag>,
    @field:JsonInclude var grunnlagReferanseListe: List<String>
) :
    Inntekt(rolle, inntektType, belop, gjelderAar, valgt, datoFom, datoTil, inntekter) {

    override fun isEqualTo(other: Inntekt): Boolean {
        if (other is Kapitalinntekt) {
            return super.isEqualTo(other)
        }
        return false
    }
}
