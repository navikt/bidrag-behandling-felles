package no.nav.bidrag.behandling.felles.grunnlag

import java.math.BigDecimal
import java.time.LocalDate

class FaktiskUtgift(datoFom: LocalDate, datoTil: LocalDate?, override val soknadsbarnId: Int, val belop: BigDecimal) :
  Periode<FaktiskUtgift>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: FaktiskUtgift): Boolean {
    return soknadsbarnId == other.soknadsbarnId && belop == other.belop
  }

}