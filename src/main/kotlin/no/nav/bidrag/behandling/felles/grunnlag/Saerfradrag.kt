package no.nav.bidrag.behandling.felles.grunnlag

import no.nav.bidrag.behandling.felles.enums.SaerfradragKode
import java.time.LocalDate
import java.util.*

class Saerfradrag(val saerfradragKode: SaerfradragKode, datoFom: LocalDate, datoTil: LocalDate?) :
  Periode<Saerfradrag>(datoFom, datoTil), IGrunnlagInnhold {

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    if (!super.equals(o)) return false
    val that = o as Saerfradrag
    return saerfradragKode == that.saerfradragKode
  }

  override fun hashCode(): Int {
    return Objects.hash(super.hashCode(), saerfradragKode)
  }

  override fun isEqualTo(other: Saerfradrag): Boolean {
    return saerfradragKode == other.saerfradragKode
  }

}