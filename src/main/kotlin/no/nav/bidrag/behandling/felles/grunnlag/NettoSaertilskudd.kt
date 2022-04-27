package no.nav.bidrag.behandling.felles.grunnlag

import java.math.BigDecimal
import java.time.LocalDate

class NettoSaertilskudd(val belop: BigDecimal, override val soknadsbarnId: Int, datoFom: LocalDate, datoTil: LocalDate) :
  Periode<NettoSaertilskudd>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: NettoSaertilskudd): Boolean {
    return belop == other.belop && soknadsbarnId == other.soknadsbarnId
  }
}