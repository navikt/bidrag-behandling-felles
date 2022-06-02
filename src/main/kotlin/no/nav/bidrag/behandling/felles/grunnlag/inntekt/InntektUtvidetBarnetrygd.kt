package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import no.nav.bidrag.behandling.felles.enums.InntektType
import no.nav.bidrag.behandling.felles.enums.Rolle
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

class InntektUtvidetBarnetrygd(
  val isDeltFordel: Boolean, rolle: Rolle, inntektType: InntektType, belop: BigDecimal, valgt: Boolean, datoFom: LocalDate,
  datoTil: LocalDate?, inntekter: List<Inntektgrunnlag>
) : Inntekt(rolle, inntektType, belop, valgt, datoFom, datoTil, inntekter) {

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    if (!super.equals(o)) return false
    val that = o as InntektUtvidetBarnetrygd
    return isDeltFordel == that.isDeltFordel
  }

  override fun hashCode(): Int {
    return Objects.hash(super.hashCode(), isDeltFordel)
  }

  override fun isEqualTo(other: Inntekt): Boolean {
    if (other is InntektUtvidetBarnetrygd) {
      return isDeltFordel == other.isDeltFordel && super.isEqualTo(other)
    }
    return false
  }

}