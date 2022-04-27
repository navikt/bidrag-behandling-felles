package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import no.nav.bidrag.behandling.felles.enums.InntektType
import no.nav.bidrag.behandling.felles.enums.Rolle
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class InntektBarn(
  override val soknadsbarnId: Int,
  rolle: Rolle,
  inntektType: InntektType,
  belop: BigDecimal,
  valgt: Boolean,
  datoFom: LocalDate,
  datoTil: LocalDate,
  inntekter: List<IInntektGrunnlag>
) :
  Inntekt(rolle, inntektType, belop, valgt, datoFom, datoTil, inntekter), ISoknadsbarn {

  override fun isEqualTo(other: Inntekt): Boolean {
    if (other is InntektBarn) {
      val inntektBarn: InntektBarn = other
      return soknadsbarnId == inntektBarn.soknadsbarnId && super.isEqualTo(other)
    }
    return false
  }

}