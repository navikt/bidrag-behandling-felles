package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class Samvaersklasse(
  override val soknadsbarnId: Int,
  val samvaersklasseId: String,
  val samvaersklasseBeskrivelse: String,
  datoFom: LocalDate,
  datoTil: LocalDate?
) :
  Periode<Samvaersklasse>(datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

  override fun isEqualTo(other: Samvaersklasse): Boolean {
    return soknadsbarnId == other.soknadsbarnId && samvaersklasseId == other.samvaersklasseId && samvaersklasseBeskrivelse == other.samvaersklasseBeskrivelse
  }

}