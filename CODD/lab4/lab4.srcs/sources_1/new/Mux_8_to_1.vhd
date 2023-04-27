----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/23/2023 09:31:41 PM
-- Design Name: 
-- Module Name: Mux_8_to_1 - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity Mux_8_to_1 is
    Port ( S : in STD_LOGIC_VECTOR (2 downto 0);
           D : in STD_LOGIC_VECTOR (7 downto 0);
           EN_MUX : in STD_LOGIC;
           Y_MUX : out STD_LOGIC);
end Mux_8_to_1;

architecture Behavioral of Mux_8_to_1 is
component Decoder_3_to_8
 port(
 I: in STD_LOGIC_VECTOR;
 EN: in STD_LOGIC;
 Y: out STD_LOGIC_VECTOR );
 end component;
 
 signal Y0 : STD_LOGIC_VECTOR (7 downto 0);

begin
 Decoder_3_to_8_0 : Decoder_3_to_8
 port map(
 I => S,
 EN => EN_MUX,
 Y => Y0
 );

Y_MUX <=( Y0(0)AND D(0) )
OR ( Y0(1) AND D(1) )
OR ( Y0(2) AND D(2) )
OR ( Y0(3) AND D(3) )
OR ( Y0(4) AND D(4) )
OR ( Y0(5) AND D(5) )
OR ( Y0(6) AND D(6) )
OR ( Y0(7) AND D(7) );

end Behavioral;


--Y_MUX<=( (NOT S(0)) AND (NOT S(1)) AND (NOT S(2)) AND D(0) ) 
--OR ( (NOT S(0)) AND (NOT S(1)) AND (S(2))     AND D(1) ) 
--OR ( (NOT S(0)) AND ( S(1))    AND (NOT S(2)) AND D(2) )
--OR ( (NOT S(0)) AND ( S(1))    AND ( S(2))    AND D(3) )
--OR ( ( S(0)   ) AND (NOT S(1)) AND (NOT S(2)) AND D(4) )
--OR ( ( S(0)   ) AND (NOT S(1)) AND ( S(2))    AND D(5) )
--OR ( ( S(0)   ) AND ( S(1))    AND (NOT S(2)) AND D(6) )
--OR ( ( S(0)   ) AND ( S(1))    AND ( S(2))    AND D(7) );
