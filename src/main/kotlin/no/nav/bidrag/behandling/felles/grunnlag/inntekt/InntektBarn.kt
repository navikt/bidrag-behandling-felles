package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import no.nav.bidrag.domain.enums.InntektType
import no.nav.bidrag.domain.enums.Rolle
import java.math.BigDecimal
import java.time.LocalDate

open class InntektBarn(
    override val soknadsbarnId: Int,
    rolle: Rolle,
    inntektType: InntektType,
    belop: BigDecimal,
    gjelderAar: String,
    valgt: Boolean,
    datoFom: LocalDate,
    datoTil: LocalDate?,
    inntekter: List<IInntektGrunnlag>
) :
    Inntekt(rolle, inntektType, belop, gjelderAar, valgt, datoFom, datoTil, inntekter), ISoknadsbarn {

    override fun isEqualTo(other: Inntekt): Boolean {
        if (other is InntektBarn) {
            val inntektBarn: InntektBarn = other
            return soknadsbarnId == inntektBarn.soknadsbarnId && super.isEqualTo(other)
        }
        return false
    }
}
