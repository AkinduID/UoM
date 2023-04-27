library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity D_FF_Sim is
end D_FF_Sim;

architecture Behavioral of D_FF_Sim is
COMPONENT D_FF
PORT(
D,Res,Clk : IN STD_LOGIC;
Q,Qbar : OUT STD_LOGIC
);
END COMPONENT;

SIGNAL a,b,c : std_logic;
SIGNAL d,e : std_logic;

begin
UUT: D_FF PORT MAP(
D => a,
Res => b,
Clk => c,
Q => d,
Qbar => e
);

process
begin
a <= '0';
b <= '0';
c <= '0';
WAIT FOR 100 ns;
a <= '0';
b <= '0';
c <= '1';
WAIT FOR 100 ns;
a <= '0';
b <= '1';
c <= '0';
WAIT FOR 100 ns;
a <= '0';
b <= '1';
c <= '1';
WAIT FOR 100 ns;
a <= '1';
b <= '0';
c <= '0';
WAIT FOR 100 ns;
a <= '1';
b <= '0';
c <= '1';
WAIT FOR 100 ns;
a <= '1';
b <= '1';
c <= '0';
WAIT FOR 100 ns;
a <= '1';
b <= '1';
c <= '1';
WAIT;
end process;

end Behavioral;