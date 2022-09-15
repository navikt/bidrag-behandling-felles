package no.nav.bidrag.behandling.felles.grunnlag

import no.nav.bidrag.behandling.felles.enums.Rolle

class PersonInfo(
  val fnr: String,
  val navn: String,
  val rolle: Rolle
) : IGrunnlagInnhold {}