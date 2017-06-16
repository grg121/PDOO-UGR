# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Mago


  @@total_magos = 0 
  def initialize(unNombre, unPoder, unMonstruoAmigo)
    @nombre = unNombre
    @poder = unPoder 
    @monstruoAmigo = unMonstruoAmigo
    @@total_magos = @@total_magos + 1 
  end
  
  def to_s
  "Nombre: #{@nombre}\nPoder:#{@poder}\nMonstruo amigo: #{@monstruoAmigo}\n"

end

  def Mago.getTotal()
    return @@total_magos
  end

  
end
