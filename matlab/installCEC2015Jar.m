
% filename = which('..\dist\CEC2015.jar');
filename = fullfile(pwd, '\..\dist\CEC2015.jar');
cpfile = which('classpath.txt');
fid = fopen(cpfile,'a');
fprintf(fid,'\n\n%s\n', filename);
fclose(fid);
fprintf('Updating classpaht.txt finished.\n')
fprintf('Please restart Matlab to use CEC 2015 competition code.\n')