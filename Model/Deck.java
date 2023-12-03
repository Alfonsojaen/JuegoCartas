package Model;

public class Deck {
    private Card[] cards;
    private boolean repartir;

        private Card [] deck;
        private boolean repartido;

        public Deck()
        {
            deck = new Card[52];
            revolverMazo();
        }

        public void revolverMazo() {
            for(int i = 0; i<52; i++) {
                deck[i] = null;
            }
            for(int i=1; i<=4; i++) {
                for(int j=0; j<13; j++) {
                    Card temp = new Card(0,"");
                    if(i==1){
                        temp.setSuit("Pica");
                        ordenarEnMazo(temp);
                    }
                    else if(i==2){
                        temp.setSuit("Corazón");
                        ordenarEnMazo(temp);
                    }
                    else if(i==3){
                        temp.setSuit("Diamante");
                        ordenarEnMazo(temp);
                    }
                    else {
                        temp.setSuit("Trébol");
                        ordenarEnMazo(temp);
                    }
                }
            }
        }

        public void ordenarEnMazo(Card card){
            for(int i=0; i<1; i++) {
                int pos = (int) Math.round(Math.random()*51);
                if(deck[pos]==null){
                    deck[pos] = card;
                }
                else {
                    i--;
                }
            }
        }

        public Card ultimaCarta() {
            for(int i = 51; i>=0; i--) {
                if(deck[i]!=null) {
                    Card temp = deck[i];
                    deck[i] = null;
                    return temp;
                }
            }
            System.out.println("¡No hay cartas en el mazo!");
            return null;
        }

        public void setRepartido(boolean v) {
            repartido = v;
        }

        public boolean getRepartido() {
            return repartido;
        }

        public Card cartaEnPos(int x) {
            if(x>51 && x<0) {
                return null;
            }
            return deck[x];
        }
    }


