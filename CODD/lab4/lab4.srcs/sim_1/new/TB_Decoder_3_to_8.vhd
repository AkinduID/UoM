----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/21/2023 02:35:45 PM
-- Design Name: 
-- Module Name: TB_Decoder_3_to_8 - Behavioral
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

entity TB_Decoder_3_to_8 is
--  Port ( );
end TB_Decoder_3_to_8;

architecture Behavioral of TB_Decoder_3_to_8 is
COMPONENT Decoder_3_to_8
PORT (I:IN STD_LOGIC_VECTOR;
EN:IN STD_LOGIC;
Y:OUT STD_LOGIC_VECTOR);
END COMPONENT;
SIGNAL g:std_logic_vector(2 downto 0);
SIGNAL h:std_logic_vector(7 downto 0);
SIGNAL e:std_logic;


begin
UUT:Decoder_3_to_8 PORT MAP(
I => g,
EN => e,
Y => h
);
process
begin
------------------------------------001
g(0)<='1';
g(1)<='0';
g(2)<='0';
e<='1';
WAIT FOR 200 ns;
-------------------------------------000
g(0)<='0';
g(1)<='0';
g(2)<='0';
e<='1';
WAIT FOR 200 ns;
------------------------------------011
g(0)<='1';
g(1)<='1';
g(2)<='0';
e<='1';
WAIT FOR 200 ns;
------------------------------------010
g(0)<='0';
g(1)<='1';
g(2)<='0';
e<='1';
WAIT FOR 200 ns;
------------------------------------110
g(0)<='0';
g(1)<='1';
g(2)<='1';
e<='1';
WAIT;
-------------------------------
end process;
end Behavioral;
