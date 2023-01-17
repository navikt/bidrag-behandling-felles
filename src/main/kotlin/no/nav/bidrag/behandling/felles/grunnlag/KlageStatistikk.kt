package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class KlageStatistikk(
  val vedtaksdato: LocalDate,
  val klageAarsakKode: String,
  val klageAarsakKategoriKode: String,
  val klageAarsakUnderkategoriKode: String
) : IGrunnlagInnhold {}