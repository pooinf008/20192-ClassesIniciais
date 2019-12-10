public class Musica{
    private String titulo;
    private String[] nomesArtistas;
    private long duracao;
    private String genero;
    private char campoHarmonico;
    private String nomeGravadora;
    
    public Musica(String titulo, String[] nomesArtistas, long duracao, String genero,
                  char campoHarmonico, String nomeGravadora){
        this.setTitulo(titulo);
        this.setNomesArtistas(nomesArtistas);
        this.setDuracao(duracao);
        this.setGenero(genero);
        this.setCampoHarmonico(campoHarmonico);
        this.setNomeGravadora(nomeGravadora);
    }    
    
    
    public boolean equals(Musica musica){
        return this.getTitulo().equals(musica.getTitulo()) && this.mesmosArtistas(musica);
    }    
    
    public boolean mesmosArtistas(Musica musica){
        return this.hasArtistas(musica) && musica.hasArtistas(this);
    }  
    
    public double getProximidade(Musica musica){
        double proximidade = 0;
        proximidade += ((this.getCampoHarmonico() == musica.getCampoHarmonico()) ? 1 : 0);
        proximidade += ((this.getNomeGravadora().equals(musica.getNomeGravadora())) ? 1 : 0);
        proximidade += ((this.getGenero().equals(musica.getGenero())) ? 1 : 0);
        return proximidade + this.getPctArtistasCoincidentes(musica);
    }
    
    public char getCampoHarmonico(){
        return this.campoHarmonico;
    } 
    
    public String getNomeGravadora(){
        return this.nomeGravadora;
    }    
    
    public String getGenero(){
        return this.genero;
    }    
    
    
    private double getPctArtistasCoincidentes(Musica musica){
        int possui = 0;
        double max = this.getNomesArtistas().length >=  musica.getNomesArtistas().length ?
                     this.getNomesArtistas().length : musica.getNomesArtistas().length; 
        for(String artista : musica.getNomesArtistas())
          if(hasArtista(artista))
            possui++;
        return possui / max;    
    }    
        
    
    private boolean hasArtistas(Musica musica){
        for(String artista : musica.getNomesArtistas())
          if(!hasArtista(artista))
            return false;
        return true;    
    }   
    
    
    private boolean hasArtista(String nomeArtista){
        for(String artista : this.nomesArtistas)
          if(artista.equals(nomeArtista))
            return true;
        return false;    
    }    
    
    
    private String getTitulo(){
        return this.titulo;
    }  
    
    private String[] getNomesArtistas(){
        return this.nomesArtistas;
    }     
    
    
    private void setTitulo(String titulo){
        this.titulo = titulo;
    }   
    
    private void setDuracao(long duracao){
        this.duracao = duracao;
    } 
    
    private void setGenero(String genero){
        this.genero = genero;
    }   
    
    private void setCampoHarmonico(char campoHarmonico){
        this.campoHarmonico = campoHarmonico;
    }  
    
    private void setNomeGravadora(String nomeGravadora){
        this.nomeGravadora = nomeGravadora;
    } 
    
    private void setNomesArtistas(String[] nomesArtistas){
        this.nomesArtistas = nomesArtistas;
    } 
    
    
}
