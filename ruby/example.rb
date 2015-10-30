# print and puts handle strings
print "test\n"
puts 'test'

# p will print anything
p 'test'
p File::methods

# pp is pretty p
require 'pp'
pp 'test'
pp File::methods

5.times { print "Odelay!" }
puts

exit unless "restaurant".include? "aura"

['toast', 'cheese', 'wine'].each { |food| print food.capitalize }
puts

population = 12_000_000_000

# symbols
# symbols start with :, like :a, :b, :sym
puts :a.class
puts :a

# constants
EmpireStateBuilding = "350 5th Avenue, NYC, NY"

# globals
$gb = "test"

(1..3).each do
  print "Much better."
  print "Ah.  More space!"
  print "My back was killin' me in those crab pincers.\n"
end

require 'net/http'
Net::HTTP.start( 'www.ruby-lang.org', 80 ) do |http|
    puts( http.get( '/en/LICENSE.txt' ).body.length )
end

puts "nil != false" if nil != false
puts "!nil == !false" if !nil == !false

addr = "kehuang"
addr << "@"
addr << "yahoo.com"
addr << "\n"

print addr

code_words = {
  'starmonkeys' => 'Phil and Pete, those prickly chancellors of the New Reich',
  'catapult' => 'chucky go-go', 'firebomb' => 'Heat-Assisted Living',
  'Nigeria' => "Ny and Jerry's Dry Cleaning (with Donuts)",
  'Put the kabosh on' => 'Put the cable box on'
}

puts code_words['catapult']
puts code_words.[]( 'catapult' )

kitty_toys =
  [:shape => 'sock', :fabric => 'cashmere'] +
  [:shape => 'mouse', :fabric => 'calico'] +
  [:shape => 'eggroll', :fabric => 'chenille']
kitty_toys.sort_by { |toy| toy[:fabric] }

p kitty_toys

kitty_toys.sort_by { |toy| toy[:shape] }.each do |toy|
  puts "Blixy has a #{ toy[:shape] } made of #{ toy[:fabric] }"
end

def dr_chams_timeline( year )
  case year
  when 1894
    "Born."
  when 1895..1913
    "Childhood in Lousville, Winston Co., Mississippi."
  when 1914..1919
    "Worked at a pecan nursery; punched a Quaker."
  when 1920..1928
    "Sailed in the Brotherhood of River Wisdomming, which journeyed \
     the Mississippi River and engaged in thoughtful self-improvement, \
     where he finished 140 credit hours from their Oarniversity."
  when 1929
    "Returned to Louisville to pen a novel about time-travelling pheasant hunters."
  when 1930..1933
    "Took up a respectable career insuring pecan nurseries.  Financially stable, he \
     spent time in Brazil and New Mexico, buying up rare paper-shell pecan trees.  Just \
     as his notariety came to a crescendo: gosh, he tried to buried himself alive."
  when 1934
    "Went back to writing his novel.  Changed the hunters to insurance tycoons and the \
     pheasants to Quakers."
  when 1935..1940
    "Took Arthur Cone, the Headmaster of the Brotherhood of River Wisdomming, as a \
     houseguest.  Together for five years, engineering and inventing."
  when 1941
    "And this is where things got interesting."
  end
end

puts dr_chams_timeline( 1941 )

# === is a less strict equal
puts "range works" if 1..24 === 13

# collect will take a block to work on a array, and return the result of the block as a new array
orig = [1,2,3,4]
res = orig.collect do |i|
  i > 3
end
p res

class TestKlass < Object; end
class TestKlass; end
class TestKlass
  def newm
  end
end

def yield_thrice
  yield 5
  yield 10
  yield 20
end

yield_thrice { |x| puts "#{x} test" }

h = { 'k1' => '<', 'k2' => 5, 'k3' => 10 }

# map converts a hash => an array based on the block's operation
hout = h.map do |k, v|
  URI.escape "#{k}=#{v}"
end

p hout
