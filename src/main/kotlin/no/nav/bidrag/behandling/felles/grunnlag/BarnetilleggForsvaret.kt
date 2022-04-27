package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class BarnetilleggForsvaret(val isBarnetilleggForsvaret: Boolean, datoFom: LocalDate, datoTil: LocalDate) :
  Periode<BarnetilleggForsvaret>(datoFom, datoTil), IGrunnlagInnhold {

  override fun isEqualTo(other: BarnetilleggForsvaret): Boolean {
    return isBarnetilleggForsvaret == other.isBarnetilleggForsvaret
  }

}