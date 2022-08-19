package no.nav.bidrag.behandling.felles.enums

/**
 * Typer grunnlag som kan innhentes av tjenesten bidrag-grunnlag.
 * Brukes for å spesifisere hvilke grunnlag man ønsker at skal innhentes for en grunnlagspakke.
 * Må ikke forveksles med GrunnlagType.
 */
enum class GrunnlagRequestType {
  AINNTEKT,
  SKATTEGRUNNLAG,
  UTVIDET_BARNETRYGD_OG_SMAABARNSTILLEGG,
  BARNETILLEGG,
  HUSSTANDSMEDLEMMER,
  EGNE_BARN_I_HUSSTANDEN,
  EGNE_BARN,
  SIVILSTAND,
  KONTANTSTOTTE,
  BARNETILSYN
  ;
}