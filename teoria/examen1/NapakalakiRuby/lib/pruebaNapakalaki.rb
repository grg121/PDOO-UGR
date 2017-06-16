#encoding: utf-8

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf-8

require_relative "mago.rb"
require_relative "poderes.rb"
require_relative "prize.rb"
require_relative "treasure_kind.rb"
require_relative "monster.rb"
require_relative "bad_consequence.rb"

class PruebaNapakalaki 
  
  @@monsters = Array.new
  
  # El rey de rosa
  prize = Prize.new(4,2)
  badconsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y
  3tesoros visibles',5 , 3, 0)
  @@monsters << Monster.new('El rey de rosa', 13, prize, badconsequence)
  
  # Ángeles de la noche ibicenca
  prize = Prize.new(4,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures('Te
  atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 
  mano visible y 1 mano oculta', 0,[TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  @@monsters<< Monster.new('Ángeles de la noche ibicenca', 14, prize, badconsequence)
  
  # 3 Byakhees de bonanza
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible 
  y otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  @@monsters << Monster.new("3 Byakhees de bonanza",8, prize, badconsequence)
  
  # Tenochtitlan
  prize = Prize.new(1,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Embobador con el lindo 
  primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET], Array.new)
  @@monsters << Monster.new("Tenochtitlan", 2, prize, badconsequence)
  
  # El sopor de Dunwich
  prize = Prize.new(1,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo 
  contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], Array.new)
  @@monsters << Monster.new("El sopor de Dunwich", 2, prize, badconsequence)
  
  # H.P. Munchcraft
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura
  visible", 0, [TreasureKind::ARMOR], Array.new)
  @@monsters << Monster.new("H.P. Munchcraft", 6, prize, badconsequence)
  
  # El gorron en el umbral
  prize = Prize.new(3,1)
  badconsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus 
  tesoros visibles", 0, 100, 0)
  @@monsters << Monster.new("El gorron en el umbral", 13, prize, badconsequence)
  
  # Demonios de Magaluf
  prize = Prize.new(4,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte
    de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y una mano
    oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  @@monsters << Monster.new("Demonios de Magaluf", 2, prize, badconsequence)
  
  # Necrófago
  prize = Prize.new(1,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos balo la ropa.
    Descarta la armadura visible", 0, [TreasureKind::ARMOR], Array.new)
  @@monsters << Monster.new("Necrofago", 13, prize, badconsequence)
  
  #El rey de rosado
  prize = Prize.new(3,2)
  badconsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 
    3 tesoros visibles", 5, 3, 0)
  @@monsters << Monster.new("El rey de rosado", 11, prize, badconsequence)
  
  # Flecher
  prize = Prize.new(1,1)
  badconsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones 
    y pierdes 2 niveles", 2, 0, 0)
  @@monsters << Monster.new("Flecher", 2, prize, badconsequence)
  
  # Bicéfalo
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos 
    para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos
    ", 3, [TreasureKind::BOTHHANDS, TreasureKind::ONEHAND], Array.new)
  @@monsters<< Monster.new("Bicéfalo", 21, prize, badconsequence)
  
  # Roboggoth
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva
    primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHANDS],Array.new)
  @@monsters<< Monster.new("Roboggoth",8,prize,badconsequence)
  
  # El espía sordo
  prize = Prize.new(1,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la 
    noche. Pierdes un casco visible", 0, [TreasureKind::HELMET], Array.new)
  @@monsters<< Monster.new("El espía sordo", 5, prize, badconsequence)
  
  # Tongue
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te 
    llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
  @@monsters<< Monster.new("Tongue", 19, prize, badconsequence)
  
  # Pollipólipo volante
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. 
    Pierdes 3 niveles.", 3, 0, 0)
  @@monsters<< Monster.new("Pollipólipo volante", 3, prize, badconsequence)
  
  # YskhtihyssgGoth
  prize = Prize.new(3,1)
  badconsequence = BadConsequence.newDeath("No le hace gracia que pronuncien
    mal su nombre. Estás muerto.")
  @@monsters<< Monster.new("YskhtihyssgGoth", 14, prize, badconsequence)
  
  # Familia feliz
  prize = Prize.new(3,1)
  badconsequence = BadConsequence.newDeath("La familia te atrapa. Estás muerto.")
  @@monsters<< Monster.new("Familia feliz", 1, prize, badconsequence)

  # Los hondos
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newDeath("Estos monstruos resultan bastante 
    superficiales y te aburren mortalmente. Estás muerto.")
  @@monsters<< Monster.new("Los hondos", 8, prize, badconsequence)
  
  # Semillas Cthulhu
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y
    2 tesoros ocultos", 2 , 0 , 2)
  @@monsters<< Monster.new("Semillas Cthulhu", 4, prize, badconsequence)
  
  # Dameargo
  prize = Prize.new(2,1)
  badconsequence = BadConsequence.newLevelSpecificTreasures("Te intentas 
  escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND], Array.new)
  @@monsters<< Monster.new("Dameargo", 1, prize, badconsequence)
  
  
  
  def PruebaNapakalaki.Combat10()
    output = Array.new
    for monstruo in @@monsters
      if monstruo.combatLevel > 10
          output << monstruo
      end
    end
    return output
  end
  

  def PruebaNapakalaki.PierdeNivel()
    output = Array.new
    for monstruo in @@monsters
      if
        monstruo.rol.death == false &&
        monstruo.rol.levels > 0 && 
        monstruo.rol.specificHiddenTreasures.empty? &&
        monstruo.rol.specificVisibleTreasures.empty? &&
        monstruo.rol.nVisibleTreasures == 0 &&
        monstruo.rol.nHiddenTreasures == 0
            output << monstruo
      
      end
      
    end
    return output
    
    
  end
  
  
  def PruebaNapakalaki.LevelSup1()
    output = Array.new
    for monstruo in @@monsters
      if monstruo.premio.levels > 1
        output << monstruo
      end
    end
    return output
    
  end
  
  def PruebaNapakalaki.PierdeTesoro(tipo)
    output = Array.new
    for monstruo in @@monsters
      encontrado = false
      i=0
      while i<monstruo.rol.specificHiddenTreasures.size() && !encontrado
        encontrado=tipo==monstruo.rol.specificHiddenTreasures[i]
         i+=1
      end
      i=0
      if !encontrado
        while i<monstruo.rol.specificVisibleTreasures.size() && !encontrado
          encontrado = tipo==monstruo.rol.specificVisibleTreasures[i]
          i+=1
        end
      end
      if encontrado
        output << monstruo
      end
    end
    return output
  end
  
  
  def PruebaNapakalaki.LevelSup1()
    output = Array.new
    for monstruo in @@monsters
      if monstruo.premio.level > 1
        output << monstruo
      end
    end
    return output
  end
  
  prueba = Array.new
 
  puts "Los monstruos que tienen un nivel de combate superior a 10 son: "
  prueba = Combat10()
  for monstruo in prueba
    puts monstruo
  end
  
  puts "Los monstruos que su mal rollo implica sólo pérdida de niveles son: "
  prueba = PierdeNivel()
  for monstruo in prueba
    puts monstruo
  end
  
  
  puts "Los monstruos que su mal rollo supone pérdida de una mano son: "
  prueba = PierdeTesoro(TreasureKind::ONEHAND)
  for monstruo in prueba
    puts monstruo
  end
  
  puts "Los monstruos que su mal rollo supone pérdida de armadura son: "
  prueba = PierdeTesoro(TreasureKind::ARMOR)
  for monstruo in prueba
    puts monstruo
  end
  
  puts "Los monstruos que su mal rollo supone pérdida de casco son: "
  prueba = PierdeTesoro(TreasureKind::HELMET)
  for monstruo in prueba
    puts monstruo
  end
  
  puts "Los monstruos que su mal rollo supone pérdida de zapatos son: "
  prueba = PierdeTesoro(TreasureKind::SHOES)
  for monstruo in prueba
    puts monstruo
  end
  
    puts "Los monstruos que su mal rollo supone pérdida de dos manos son: "
  prueba = PierdeTesoro(TreasureKind::BOTHHANDS)
  for monstruo in prueba
    puts monstruo
  end
  
  puts "Los monstruos que su buen rollo indica ganancia de nivel superior a 10 son: "
    prueba = LevelSup1()
    for monstruo in prueba
      puts monstruo
    end
    
  panoramix = Mago.new("Panoramix", Poderes::CAMBIANTE, @@monsters[1])
  merlin = Mago.new("Merlín", Poderes::INVISIBLE, @@monsters[2])
  hoz = Mago.new("Hoz", Poderes::VOLADOR,@@monsters[@@monsters.size() -1])
  
  @@magos = [merlin, hoz] 
  
  puts @@monsters[1] 
  
  for mago in @@magos 
    puts mago
  end
  
    puts "\nEl total de magos creados es: \n"
    puts Mago.getTotal()
        
end  
