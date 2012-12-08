#!/usr/bin/perl

use POSIX;

srand (time ^ $$ ^ unpack "%L*", `ps axww | gzip`);

usage() if $#ARGV < 1;

sub usage
{
	print "Usage: $0 -e plaintext pad \n";
	print "       $0 -d encryptedtext pad \n";
	print "       $0 -g length \n\n";
	print "-e : encrypt\n-d : decrypt\n-g : generate pad\n\n";
	exit(1);
}

# in this pad generator, J is not used
sub generate_pad
{
	for ($c=0;$c<$_[0];$c++) {
		$r=ord('A')+floor(rand 24);
		if ($r>=ord('J')) { $r++; }
		print chr($r);
		if (!(($c+1)%5)) { print " "; }
	}
	print "\n";
}	

sub decrypt
{
	for ($c=0;$c<length($_[0]);$c++) {
		$cypher=ord(uc(substr($_[0],$c,1)));
		$pad=ord(uc(substr($_[1],$c,1)));
		print chr($cypher) . " " . chr($pad) . ": ";
		if ($cypher>=ord('J')) { $cypher--; }
		if ($pad>=ord('J')) { $pad--; }
		$modres=($cypher-$pad)%25;
		print chr($modres+ord('A')) . "  ";
		print "\n c: ".$cypher." p: ".$pad." mod: ".$modres."\n";
	}
	print "\n";
}

sub encrypt
{
	for ($c=0;$c<length($_[0]);$c++) {
		$org=ord(uc(substr($_[0],$c,1)));
		$pad=ord(uc(substr($_[1],$c,1)));
		print chr($org) . " " . chr($pad) . ": ";
		if ($org>=ord('J')) { $org--; }
		if ($pad>=ord('J')) { $pad--; }
		$modres=($org+$pad-2*(ord('A')+1))%25;
		print chr($modres+ord('A')) . "  ";
		print "\n o: ".$org." p: ".$pad." mod: ".$modres."\n";
	}
	print "\n";
}

generate_pad($ARGV[1]);
encrypt("twoby", "athop");
decrypt("uqwqo", "athop");
