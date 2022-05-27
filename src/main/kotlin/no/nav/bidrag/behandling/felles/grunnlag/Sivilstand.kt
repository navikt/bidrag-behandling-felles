package no.nav.bidrag.behandling.felles.grunnlag

import no.nav.bidrag.behandling.felles.enums.Rolle
import no.nav.bidrag.behandling.felles.enums.SivilstandKode
import java.time.LocalDate

class Sivilstand(
  val rolle: Rolle,
  datoFom: LocalDate,
  datoTil: LocalDate,
  val sivilstandKode: SivilstandKode,
  val beskrivelse: String
) :
  Periode<Sivilstand>(datoFom, datoTil), IGrunnlagInnhold {

  override fun isEqualTo(other: Sivilstand): Boolean {
    return rolle == other.rolle && sivilstandKode == other.sivilstandKode && beskrivelse == other.beskrivelse
  }

}